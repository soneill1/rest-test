package com.geowarin.rest;

import com.geowarin.dao.Article;
import com.geowarin.dao.Car;
import com.geowarin.domain.Message;
import com.geowarin.service.IArticleService;
import com.geowarin.service.ICarService;
import com.geowarin.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.net.URI;
import java.util.List;

@Path("/")
@Component
public class RestResource {
	// test
	public static String TOKEN = "";
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private ICarService carService;

    @Autowired
    private MessageService messageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("hello")
    public String hello() {
        return "Hello World";
    }

    @GET
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    @Path("messages")
    public List<Message> message() {
        return messageService.getMessages();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("messages2")
    public String test(@QueryParam("articleId") int articleId, 
			@QueryParam("title") String title, @QueryParam("category") String category) {
        return articleId + title + category;
    }
    
    @GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Article> getArticleDetails() {
		List<Article> list = articleService.getAllArticles(); 
		return articleService.getAllArticles();
	}
    
    @GET
	@Path("/cars")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Car> getCarDetails() {
		List<Car> list = carService.getAllCars(); 
		return carService.getAllCars();
	}
    
    @POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addArticle(@QueryParam("title") String title,
			 @QueryParam("category") String category) {
		
		Article article = new Article(title, category);
        boolean isAdded = articleService.addArticle(article);
        
        if (!isAdded) {
	        return Response.status(Status.CONFLICT).build();
        }
        
        return Response.created(URI.create("/spring-app/article/"+ article.getArticleId())).build();
	}
    
}

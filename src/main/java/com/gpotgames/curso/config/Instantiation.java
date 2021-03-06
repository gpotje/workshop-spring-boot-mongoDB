package com.gpotgames.curso.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gpotgames.curso.domain.Post;
import com.gpotgames.curso.domain.User;
import com.gpotgames.curso.dto.AuthorDTO;
import com.gpotgames.curso.dto.CommentDTO;
import com.gpotgames.curso.repository.PostRepository;
import com.gpotgames.curso.repository.UserRepository;

@Configuration
public class Instantiation  implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String body = "Vou viajar para São Paulo. Abraços!";
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viajem", body,new AuthorDTO(maria));	
		Post p2 = new Post(null, sdf.parse("25/04/2019"), "valeu", body,new AuthorDTO(maria));
	
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("2018/03/22"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("2018/03/23"), new AuthorDTO(alex));
		
		p1.getComment().addAll(Arrays.asList(c1,c2));
		p2.getComment().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(p1,p2));
		
		maria.getPosts().addAll(Arrays.asList(p1,p2));
		userRepository.save(maria);
		
	}

}

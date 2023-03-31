package com.dota2.rozuke;

import com.dota2.rozuke.persistence.HeroAttribute;
import com.dota2.rozuke.persistence.TypeAttack;
import com.dota2.rozuke.persistence.crud.HeroRepository;
import com.dota2.rozuke.persistence.crud.MatchRepository;
import com.dota2.rozuke.persistence.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RozukeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RozukeApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(MatchRepository repository) {
//		return args -> {
//			Match match = new Match(
//					15234,
//					3000,
//					5,
//					7,
//					18,
//					new Item[]{ new Item("item", 200), new Item("item 1", 400), new Item("item 2", 2000)},
//					new HeroAverage(480, 500, 40, 100, 30, "Attack"),
//					new PlayStyle(20, 30, 50, 60));
//
//			repository.insert(match);
//		};
//	}

}

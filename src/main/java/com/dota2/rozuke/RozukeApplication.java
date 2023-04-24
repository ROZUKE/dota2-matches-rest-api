package com.dota2.rozuke;

import com.dota2.rozuke.domain.dto.MatchDTO;
import com.dota2.rozuke.domain.service.HeroService;
import com.dota2.rozuke.domain.service.MatchService;
import com.dota2.rozuke.persistence.crud.HeroRepositoryCRUD;
import com.dota2.rozuke.persistence.crud.MatchRepositoryCRUD;
import com.dota2.rozuke.persistence.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class RozukeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RozukeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(MatchService service, HeroRepositoryCRUD heroRepository, HeroService heroService) {
		return args -> {

//			Optional<Hero> hero = heroRepository.findByName("Io");
//			hero.ifPresent(h -> {
//				service.saveNewMatch(new MatchDTO(
//						153232234,
//						h,
//						true,
//						5000,
//						17,
//						8,
//						26,
//						new Item[]{ new Item("item", 200), new Item("item 1", 400), new Item("item 2", 2000)},
//						new HeroAverage(480, 500, 40, 100, 30, "Attack"),
//						new PlayStyle(20, 30, 50, 60)));
//			});
		};
	}

}

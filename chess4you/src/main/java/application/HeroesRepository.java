package application;

import org.springframework.data.jpa.repository.JpaRepository;

interface HeroesRepository extends JpaRepository<Hero, Long> {
}

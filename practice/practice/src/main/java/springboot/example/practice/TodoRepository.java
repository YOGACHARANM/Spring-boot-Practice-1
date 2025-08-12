package springboot.example.practice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository< Todo ,Long >  {
}

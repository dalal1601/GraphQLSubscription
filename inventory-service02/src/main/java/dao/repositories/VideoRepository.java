package dao.repositories;

import dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface VideoRepository extends JpaRepository<Video, Long> {
}

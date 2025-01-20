package si.um.feri.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import si.um.feri.ris.models.Rezervacija;

import java.sql.Timestamp;
import java.util.List;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {
    @Query("SELECT r FROM Rezervacija r WHERE r.steviloOseb > :stevOseb AND r.datum > :startDate")
    List<Rezervacija> findRezervacijaByDatumAndSteviloOseb(@Param("stevOseb") int stevOseb, @Param("startDate") Timestamp startDate);


}
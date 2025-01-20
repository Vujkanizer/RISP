package si.um.feri.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import si.um.feri.ris.models.Dogodek;

import java.util.List;

public interface DogodekRepository extends JpaRepository<Dogodek, Long> {


    @Query("SELECT d FROM Dogodek d WHERE d.steviloMiz > 5 AND d.odobren = true AND d.cenaVstopnice < 20.0 ")
    List<Dogodek> findBydog(boolean odobren, Float cenaVstopnice);

    @Query("SELECT d FROM Dogodek d JOIN fetch d.klub_dogodek k WHERE d.cenaVstopnice > :cenaVstopnice")
    List<Dogodek> findAllByCenaVstopnice(@Param("cenaVstopnice") Float cenaVstopnice);

    @Query("SELECT d FROM  Dogodek  d JOIN fetch d.klub_dogodek k JOIN fetch k.tip_kluba t WHERE d.steviloMiz > :steviloMiz")
    List<Dogodek> findAllBySteviloMiz(@Param("steviloMiz") int steviloMiz);

    @Query("SELECT d FROM Dogodek d WHERE d.odobren = true ")
    List<Dogodek> findAllByOdobren();

    @Query("SELECT d FROM Dogodek d WHERE d.uporabnik_dogodek.idUporabnik = :uporabnik_iduporabnik ")
    List<Dogodek> findByidu(int uporabnik_iduporabnik);



}

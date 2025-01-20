//package si.um.feri.ris.service;
//
//
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import si.um.feri.ris.models.Uporabnik;
//import si.um.feri.ris.repository.UporabnikRepository;
//
//import java.util.List;
//
//@Service
//public class UporabnikAuthService implements UserDetailsService {
//
//    private final UporabnikRepository uporabnikRepository;
//
//    public UporabnikAuthService(UporabnikRepository uporabnikRepository) {
//        this.uporabnikRepository = uporabnikRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username){
//        Uporabnik u = uporabnikRepository.findByEmail(username);
//
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(u.getEmail())
//                .password(u.getGeslo())
//                .build();
//
//
//
//    }
//}

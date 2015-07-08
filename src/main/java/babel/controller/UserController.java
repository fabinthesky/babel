package babel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import babel.entity.Contact;
import babel.entity.Trophy;
import babel.entity.User;
import babel.repository.UserGamesRepository;
import babel.repository.UserRepository;

/**
 * 
 * @author fdesert
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

		@Autowired
		private UserRepository userRepo;
		
		@Autowired
		private UserGamesRepository userGamesRepo;
		
		@RequestMapping(value="/search", method = RequestMethod.GET, params = {"search"})
		public List<User> getAllUsers(@RequestParam(value = "search") String search){
			List<User> result = userRepo.searchByUsernameLike(search);
			return result;
		}
		/**
		 * Return user's informations
		 * @param 
		 * @return informations linked to the user
		 */
		@RequestMapping(method = RequestMethod.GET, params = {"username"})
		public User getUserByUsername(@RequestParam(value = "username", required = true) String username) {
			return userRepo.findByUsername(username);
		}
		
		/**
		 * Create user
		 * @param user
		 */
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public void createUserAccount(@RequestBody User user) {
			userRepo.save(user);
		}
		
		/**
		 * Delete user with username given in parameter
		 * @param username
		 */
		@RequestMapping(value = "/delete", method = RequestMethod.POST, params = "username")
		public void deleteUserAccount(@RequestParam(value = "username", required = true) String username) {
			User user = userRepo.findByUsername(username);
			userRepo.delete(user);
		}
		
		/**
		 * Get user's list of trophies
		 * @param username
		 * @return a list of trophies
		 */
		@RequestMapping(value = "/trophy", method = RequestMethod.GET, params = "username")
		public List<Trophy> getUserTrophies(@RequestParam(value = "username", required = true) String username) {
			User user = userRepo.findByUsername(username);
			return user.getTrophies();
		}
		
		/**
		 * Get user's list of contacts
		 * @param username
		 * @return a list of contacts 
		 */
		@RequestMapping(value = "/contacts", method = RequestMethod.GET, params = "username")
		public List<Contact> getUserContacts(@RequestParam(value = "username", required = true) String username) {
			User user = userRepo.findByUsername(username);
			return user.getContacts();
		}
		
		/**
		 * Add a trophy to user's list of trophies
		 * @param trophy
		 * @param username
		 */
//		@RequestMapping(value = "/trophy/add", method = RequestMethod.POST, params = "username")
//		public void addTrophy(@RequestBody Trophy trophy, @RequestParam(value = "username", required = true) String username) {
//			User user = userRepo.findByUsername(username);
//			List<Trophy> troph�es = user.getTrophies();
//			troph�es.add(trophy);
//			user.setTrophies(troph�es);
//			userRepo.save(user);
//		}	
}

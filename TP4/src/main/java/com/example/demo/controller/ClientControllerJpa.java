package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientControllerJpa {

	@Qualifier("clientRepository")
	@Autowired
	private final ClientRepository repository;

//defino en repositorio que quiero utilizar
	public ClientControllerJpa(@Qualifier("clientRepository") ClientRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/")
	public Iterable<Client> getClients() {
		return repository.findAll();
	}

	@GetMapping("/BySurname/{surname}")
	public Iterable<Client> getClientsBySurname(@PathVariable String surname) {
		return repository.findAllBySurname(surname);
	}

	@GetMapping("/ByName/{name}")
	public Iterable<Client> getClientsByName(@PathVariable String name) {
		return repository.findAllByName(name);
	}

	@PostMapping("/")
	public Client newClient(@RequestBody Client c) {
		return repository.save(c);
	}

	@GetMapping("/{id}")
	Optional<Client> one(@PathVariable Long id) {

		return repository.findById(id);
	}

	@PutMapping("/{id}")
	Client replaceClient(@RequestBody Client newClient, @PathVariable Long id) {
		return repository.findById(id).map(person -> {
			person.setName(newClient.getName());
			person.setSurname(newClient.getSurname());
			return repository.save(person);
		}).orElseGet(() -> {
			newClient.setDni(id);
			return repository.save(newClient);
		});
	}

	@DeleteMapping("/{id}")
	void deletePerson(@PathVariable Long id) {
		repository.deleteById(id);
	}
}

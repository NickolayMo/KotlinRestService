package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.management.loading.ClassLoaderRepository

@RestController
@RequestMapping("/persons")
class PersonController {
    @Autowired
    lateinit var repository: PersonRepository

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Person? = repository.findById(id)

    @GetMapping
    fun findAll():List<Person> = repository.findAll()

    @PostMapping
    fun add(@RequestBody person: Person): Person = repository.save(person)

    @PutMapping
    fun update(@RequestBody person: Person): Person = repository.update(person)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): Boolean = repository.removeById(id)

}
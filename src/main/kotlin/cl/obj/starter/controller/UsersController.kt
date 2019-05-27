package cl.obj.starter.controller

import cl.obj.starter.model.Users
import cl.obj.starter.service.UsersService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*


/**
 * Created by Camilo Jorquera on 29-10-18
 */
@RestController
@RequestMapping("/api/v1/users")
class UsersController(var usersService: UsersService) {

    companion object {
        val logger = LoggerFactory.getLogger(UsersController::class.java)
    }

    @GetMapping("/email/{email}")
    fun getSome(@PathVariable email:String) : Users {
        return usersService.findByEmail(email)
    }

    @GetMapping
    fun getAll() : List<Users> {
        return usersService.findAll()
    }

    @PostMapping
    fun create(@RequestBody users: Users) {
        logger.info("/post")
        usersService.insertUser(users)
    }

    @PutMapping
    fun update(@RequestBody users: Users) {
        logger.info("/put")
        usersService.updateUser(users)
    }

    @DeleteMapping("/email/{email}")
    fun delete(@PathVariable email: String) {
        logger.info("/delete")
        usersService.deleteUsers(email)
    }

}
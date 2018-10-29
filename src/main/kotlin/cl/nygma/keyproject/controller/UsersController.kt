package cl.nygma.keyproject.controller

import cl.nygma.keyproject.model.Users
import cl.nygma.keyproject.service.UsersService
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

    @PostMapping
    fun create() {
        logger.info("/post")
    }

    @PutMapping
    fun update() {
        logger.info("/put")
    }

    @DeleteMapping
    fun delete() {
        logger.info("/delete")
    }

}
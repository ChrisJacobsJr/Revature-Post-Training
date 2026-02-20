package com.jacobs.chinook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String hello() {
        return "Working";
    }

    /**
     * Example:
     *
     * @PostMapping("/albums")
     * public Album createAlbum(@RequestBody @Valid Album album) {
     *     return albumService.createAlbum(album);
     * }
     *
     * Notice the @Valid annotation. It cleanly throws a 400 error (with useful info apparently)
     * if any of the @NotNull fields are null.
     */
}

package com.mbps.cd.fileservice.web;

import com.mbps.cd.fileservice.domain.User;
import com.mbps.cd.fileservice.domain.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @project: part5_zuul
 * @description:
 * @author: Single Fan
 * @create: 2019-08-29
 **/
@RestController
@Api("测试的controller")
public class FileUploadController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/uploadfile")
    public @ResponseBody String handleFileUpload(@RequestParam(value = "file",
            required = true)MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);

        return fileToSave.getAbsolutePath();
    }
    @ApiOperation("hello")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findSthById(@PathVariable Long id){
        User result = userRepository.findOne(id);
        return result;
    }
}

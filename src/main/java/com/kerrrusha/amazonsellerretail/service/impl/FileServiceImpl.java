package com.kerrrusha.amazonsellerretail.service.impl;

import com.kerrrusha.amazonsellerretail.service.FileService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    @Override
    @SneakyThrows
    public String read(String filepath) {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }
}

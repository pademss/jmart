package com.fatmaJmartKD;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.stream.Collectors;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fatmaJmartKD.dbjson.JsonDBEngine;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

/**
 * Main method dari Jmart
 *
 * @author fatma
 * @version 8/11/2021
 */

@SpringBootApplication
public class Jmart{
	public static long DELIVERED_LIMIT_MS;
	public static long ON_DELIVERY_LIMIT_MS;
	public static long ON_PROGRESS_LIMIT_MS;
	public static long WAITING_CONF_LIMIT_MS;
	
	
	public static void main(String[] args){
        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
	}
}

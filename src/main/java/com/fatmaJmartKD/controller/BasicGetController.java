package com.fatmaJmartKD.controller;

/**
 * Class BasicGetController - Controller untuk mendapatkan page dan barang sesuai id
 *
 * @author Fatma Putri Ramadhani
 *
 */

import com.fatmaJmartKD.Algorithm;
import com.fatmaJmartKD.dbjson.JsonTable;
import com.fatmaJmartKD.dbjson.Serializable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface BasicGetController<T extends Serializable> {

	//get by page
    @GetMapping("/page")
    default @ResponseBody List<T> getPage(@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue="5") int pageSize){
        return Algorithm.<T>paginate(getJsonTable(),page,pageSize,e -> true);
    }

    //get by id
    @GetMapping("/{id}")
    default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(),(e) -> e.id == id);
    }

    public abstract JsonTable<T> getJsonTable();
}

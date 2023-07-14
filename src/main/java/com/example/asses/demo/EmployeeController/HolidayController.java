package com.example.asses.demo.EmployeeController;

import com.example.asses.demo.EmployeeDto.HolidayDto;
import com.example.asses.demo.EmployeeService.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/holidays")
public class HolidayController {
    private final HolidayService holidayService;

    @Autowired
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping("/list")
    public List<HolidayDto> getAllHolidays() {
        return holidayService.getAllHolidays();
    }}

//    @PostMapping
//    public HolidayDTO addHoliday(@RequestBody HolidayDTO holidayDTO) {
//        return holidayService.addHoliday(holidayDTO);
//    }
//
//    @GetMapping("/upcoming")
//    public List<HolidayDTO> getUpcomingHolidays() {
//        return holidayService.getUpcomingHolidays();
//    }
//}
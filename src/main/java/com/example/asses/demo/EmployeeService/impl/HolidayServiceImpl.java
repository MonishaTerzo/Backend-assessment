package com.example.asses.demo.EmployeeService.impl;

import com.example.asses.demo.EmployeeDto.Employeedto;
import com.example.asses.demo.EmployeeDto.HolidayDto;
import com.example.asses.demo.EmployeeRepository.HolidayRepository;
import com.example.asses.demo.EmployeeService.HolidayService;
import com.example.asses.demo.model.Employee;
import com.example.asses.demo.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class HolidayServiceImpl implements HolidayService {
    private HolidayRepository holidayRepository;
@Autowired
    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public List<HolidayDto> getAllHolidays() {
        List<Holiday> holidays = holidayRepository.findAll();
        return holidays.stream().map((holiday) -> maptoholidaydto(holiday)).collect(Collectors.toList());
    }


//    @Override
//    public void addHoliday(HolidayDto holidayDto) {
//
//    }
//
//    @Override
//    public List<HolidayDto> getUpcomingHolidays() {
//        return null;
//    }

    public Holiday maptoholiday(HolidayDto holi) {
        Holiday holiday = new Holiday();
        holiday.setName(holi.getName());
        holiday.setDate(holi.getDate());
        return holiday;
    }


    public HolidayDto maptoholidaydto(Holiday holiday) {
        HolidayDto holidaydto = new HolidayDto();
        holidaydto.setName(holiday.getName());
        holidaydto.setDate(holiday.getDate());
        return holidaydto;
    }
}

package com.example.asses.demo.EmployeeService;

import com.example.asses.demo.EmployeeDto.HolidayDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HolidayService {
    List<HolidayDto> getAllHolidays();
//    void addHoliday (HolidayDto holidayDto);
//    List<HolidayDto> getUpcomingHolidays();


}

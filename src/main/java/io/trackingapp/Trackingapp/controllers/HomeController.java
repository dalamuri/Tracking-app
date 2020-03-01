package io.trackingapp.Trackingapp.controllers;

import io.trackingapp.Trackingapp.models.LocationStats;
import io.trackingapp.Trackingapp.services.VirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    VirusDataService vds;
    @GetMapping("/virustracker")
    public String home(Model modal){

        List<LocationStats> allStats = vds.getAllStats();
        int totalCount = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPreviousDay()).sum();

        modal.addAttribute("totalReportedCases", totalCount);
        modal.addAttribute("locationStats",allStats);
        modal.addAttribute("totalNewCases",totalNewCases);

        return "home";
    }
}

package com.example.demo.service.Impl;

import com.example.demo.Dao.impl.ReportDaoImpl;
import com.example.demo.model.Report;
import com.example.demo.service.Service;

import java.util.List;

public class ReportServiceImpl implements Service<Report> {
      ReportDaoImpl reportDao = new ReportDaoImpl();

      @Override
      public Report get(String login) {
            return reportDao.get(login);
      }

      @Override
      public Report get(int id) {
            return reportDao.get(id);
      }

      @Override
      public List<Report> getAll() {
            return reportDao.getAll();
      }

      @Override
      public void save(Report report) {
            reportDao.save(report);
      }
}

package ru.kpfu.itis.vagaviev.service.Impl;

import ru.kpfu.itis.vagaviev.Dao.impl.ReportDaoImpl;
import ru.kpfu.itis.vagaviev.model.Report;
import ru.kpfu.itis.vagaviev.service.Service;

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

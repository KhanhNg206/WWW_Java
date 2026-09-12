package org.example.ontaptk1_restapi_de01.model;

import jakarta.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.json.bind.annotation.JsonbTransient;

@ApplicationScoped
public class GrandeReport implements Serializable {
    String studentId;
    String studentName;
    String semester;
    List<String> selectedSubjects;

    @JsonbTransient
    private List<GrandeReport> grandeReports = new ArrayList<>();

    public GrandeReport(String studentId, String studentName, String semester, List<String> selectedSubjects) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.semester = semester;
        this.selectedSubjects = selectedSubjects;
    }

    public GrandeReport() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<String> getSelectedSubjects() {
        return selectedSubjects;
    }

    public void setSelectedSubjects(List<String> selectedSubjects) {
        this.selectedSubjects = selectedSubjects;
    }

    @JsonbTransient
    public List<GrandeReport> getGrandeReports() {
        return grandeReports;
    }

    public void setGrandeReports(List<GrandeReport> grandeReports) {
        this.grandeReports = grandeReports;
    }

    public void addReport(GrandeReport report) {
        grandeReports.add(report);
    }

    public GrandeReport findByStudentId(String studentId) {

        for (GrandeReport report : grandeReports) {

            if (report.getStudentId().equals(studentId)) {
                return report;
            }
        }
        return null;
    }
}

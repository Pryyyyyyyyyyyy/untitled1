package homework;

public class Konspekt {
    private String subjectName;
    private String studentFullName;
    private int numPages;
    private int year;
    private String coverColor;
    private String institutionName;

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCoverColor() {
        return coverColor;
    }

    public void setCoverColor(String coverColor) {
        this.coverColor = coverColor;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public static void main(String[] args) {
        Konspekt k = new Konspekt();
        k.setSubjectName("Физра");
        k.setStudentFullName("Порошенко Петро Рошенович");
        k.setNumPages(50);
        k.setYear(2022);
        k.setCoverColor("Красный");
        k.setInstitutionName("Школа");

        System.out.println("Название предмета: " + k.getSubjectName());
        System.out.println("ФИО студента: " + k.getStudentFullName());
        System.out.println("Количество страниц: " + k.getNumPages());
        System.out.println("Год выпуска: " + k.getYear());
        System.out.println("Цвет обложки: " + k.getCoverColor());
        System.out.println("Название заведения: " + k.getInstitutionName());
    }
}




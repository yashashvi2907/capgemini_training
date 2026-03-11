package practicequestion;

import java.util.ArrayList;
import java.util.List;

public class m1pratcie {
    public static void main(String[] args) {
        Bank bp = new BusinessLoan(5);
        bp.assignLoans(new int[]{10000000, 456856, 368352});
        bp.averageLoan();
        bp.maxLoan();
        bp.minLoan();

        IFilm f = new Film();
        f.setTitle("happy new yer");
        f.setDirector("farah khan");
        f.setYear(2000);
        IFilmLibrary fm = new FilmLibrary();
        fm.addFilm(f);
        System.out.println(fm.getFilms());
        System.out.println(fm.getTotalFilmCount());
        List<IFilm> ls = fm.searchFiles("happy new year");

        for(IFilm it : ls)
        {
            System.out.println(it);
        }
    }
}
interface Bank
{
    void assignLoans(int[] loans);
    void averageLoan();
    void maxLoan();
    void minLoan();
}

class PersonalLoanDept implements Bank
{
    int[] loanAmount;


    public PersonalLoanDept(int client) {
        loanAmount = new int[client];
    }
    public void assignLoans(int[] loans)
    {
        int len = Math.min(loanAmount.length, loans.length);
        for( int i =0; i<len; i++)
        {
            loanAmount[i]=loans[i];
        }
        System.out.println("loans for clients processed");
    }

    public void averageLoan()
    {
        int sum = 0;

        for(int loan : loanAmount)
        {
            sum+=loan;
        }
        double avgloan = sum / loanAmount.length;

        System.out.printf("average loan amount for client is %.2f\n", avgloan);
    }

    public void maxLoan()
    {
        int maxi = Integer.MIN_VALUE;

        for( int loan : loanAmount)
        {
            if(maxi < loan)
            {
                maxi = loan;
            }
        }
        System.out.println("maximum loan :"+ maxi);
    }
    public void minLoan()
    {
        int mini = Integer.MAX_VALUE;

        for( int loan : loanAmount)
        {
            if(mini > loan && loan > 0)
            {
                mini = loan;
            }
        }
        System.out.println("minimum loan :"+ mini);
    }

}
class BusinessLoan implements Bank
{

    int[] loanAmount;


    public BusinessLoan(int client) {
      loanAmount = new int[client];
    }
    public void assignLoans(int[] loans)
    {
        int len = Math.min(loanAmount.length, loans.length);
        for( int i =0; i<len; i++)
        {
            loanAmount[i]=loans[i];
        }
        System.out.println("loans for clients processed");
    }

    public void averageLoan()
    {
        int sum = 0;

        for(int loan : loanAmount)
        {
            sum+=loan;
        }
        double avgloan = sum / loanAmount.length;

        System.out.printf("average loan amount for client is %.2f\n", avgloan);

    }
    public void maxLoan()
    {
        int maxi = Integer.MIN_VALUE;

        for( int loan : loanAmount)
        {
            if(maxi < loan)
            {
                maxi = loan;
            }
        }
        System.out.println("maximum loan :"+ maxi);
    }
    public void minLoan()
    {
        int mini = Integer.MAX_VALUE;

        for( int loan : loanAmount)
        {
            if(mini > loan && loan > 0)
            {
                mini = loan;
            }
        }
        System.out.println("minimum loan :"+ mini);
    }
}
interface IFilm
{
    void setTitle(String title);
    String getTitle();
    void setDirector(String Director);
    String Director();
    void setYear(int year);
    int getYear();
}
class Film implements IFilm
{
    String title;
    String director;
    int year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String Director() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "movie: " + getTitle() + "director: " + Director()+ "year: " + getYear();
    }
}
interface IFilmLibrary
{
    void addFilm(IFilm film);
    void removeFilm(String title);
    List<IFilm> searchFiles(String query);
    List<IFilm>getFilms();
    int getTotalFilmCount();


}
class FilmLibrary implements IFilmLibrary
{
    List<IFilm>list = new ArrayList<>();

    public void addFilm(IFilm film)
    {
        list.add(film);
    }
    public void removeFilm(String title)
    {
        for( int i =0; i<list.size(); i++)
        {
            if(list.get(i).getTitle().equalsIgnoreCase(title));
        }
    }

    public List<IFilm> searchFiles(String query)
    {
        List<IFilm>res = new ArrayList<>();

        for( IFilm film : list)
        {
            if(film.getTitle().equalsIgnoreCase(query) || film.Director().equalsIgnoreCase(query))
            {
                res.add(film);
            }

        }
        return res;
    }
    public List<IFilm> getFilms()
    {
        return list;
    }
    public int getTotalFilmCount()
    {
        return list.size();
    }

}

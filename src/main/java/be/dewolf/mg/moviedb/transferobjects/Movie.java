package be.dewolf.mg.moviedb.transferobjects;

import be.dewolf.mg.base.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by yannis on 22/06/14.
 */
public class Movie {

    private List<Person> actorList;
    private int releaseYear;
    private String title;

    private Movie() {

    }

    public static class MovieBuilder implements Builder<Movie> {

        private ImmutableList.Builder<Person> actorList;
        private int releaseYear;
        private String title;

        public MovieBuilder() {
            this.actorList = ImmutableList.builder();
        }

        public MovieBuilder addActor(Person actor) {
            this.actorList.add(actor);
            return this;
        }

        public MovieBuilder setReleaseYear(int year){
            this.releaseYear = year;
            return this;
        }

        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        @Override
        public Movie build() {
            Preconditions.checkArgument(releaseYear > 1870);
            Preconditions.checkNotNull(title);
            Preconditions.checkArgument(!title.isEmpty());

            Movie movie = new Movie();
            movie.actorList = actorList.build();
            movie.title = title;
            movie.releaseYear = releaseYear;

            return movie;
        }
    }


}

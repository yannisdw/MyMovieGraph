package be.dewolf.mg.moviedb.partialObjects;

import be.dewolf.mg.base.Builder;
import com.google.common.base.Preconditions;

/**
 * Created by yannis on 22/06/14.
 */
public class MovieResult {

    private String title;
    private String id;
    private String releaseDate;

    private MovieResult() {}

    public static Builder<MovieResult> builder() {
        return new MovieBuilder();
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public static class MovieBuilder implements Builder<MovieResult> {

        private String title;
        private String id;
        private String releaseDate;

        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public MovieBuilder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        @Override
        public MovieResult build() {

            Preconditions.checkNotNull(title);
            Preconditions.checkNotNull(id);
            Preconditions.checkNotNull(releaseDate);

            MovieResult movieResult = new MovieResult();
            movieResult.id = id;
            movieResult.releaseDate = releaseDate;
            movieResult.title = title;
            return movieResult;
        }
    }
}

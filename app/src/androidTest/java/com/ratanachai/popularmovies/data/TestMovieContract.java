package com.ratanachai.popularmovies.data;

import android.net.Uri;
import android.test.AndroidTestCase;

/**
 * Created by keng on 15/09/21.
 */
public class TestMovieContract extends AndroidTestCase {

    private static final int TEST_MOVIE_ID = TestUtilities.MAD_MAX_MOVIE_ID;

    public void testBuildMovieUri(){
        Uri movieUri = MovieContract.MovieEntry.buildMovieUri(TEST_MOVIE_ID);
        assertNotNull("Error: Null Uri returned", movieUri);
        assertEquals("Error: Movie ID not appended to the end of Uri",
                Integer.toString(TEST_MOVIE_ID), movieUri.getLastPathSegment());
        assertEquals("Error: Movie Uri does not match",
                movieUri.toString(), "content://com.ratanachai.popularmovies/movie/76341");
    }

    public void testBuildMoviesUri(){
        Uri moviesUri = MovieContract.MovieEntry.buildMoviesUri();
        assertEquals("Error: Movies Uri does not match",
                moviesUri.toString(), "content://com.ratanachai.popularmovies/movie");
    }

    public void testBuildMovieReviewsUri(){
        Uri reviewsUri = MovieContract.ReviewEntry.buildMovieReviewsUri(TEST_MOVIE_ID);
        assertEquals("Error: Reviews Uri does not match",
                reviewsUri.toString(), "content://com.ratanachai.popularmovies/movie/76341/reviews");
    }
    public void testBuildMovieVideosUri(){
        Uri reviewsUri = MovieContract.VideoEntry.buildMovieVideosUri(TEST_MOVIE_ID);
        assertEquals("Error: Videos Uri does not match",
                reviewsUri.toString(), "content://com.ratanachai.popularmovies/movie/76341/videos");
    }

}
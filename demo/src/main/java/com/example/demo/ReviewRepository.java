package com.example.demo;

import Model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepository {
    private final JdbcTemplate jdbc;

    public ReviewRepository(
            JdbcTemplate jdbc
    ){
        this.jdbc=jdbc; //using constructor injection to get the jdbctemplate bean from context
                        //jdbc bean here is added by H2 dependency

    }


    public void storeReview(Review review){
        String sql="INSERT INTO review (name,content) VALUES (?,?)";

        jdbc.update(sql,review.getName(),review.getContent());
    }

    public List<Review> findAllReviews(){
        String sql="SELECT * FROM review";

        //create a rowmapper to map the row to instance
        RowMapper<Review> reviewRowMapper=(r,i)->{ //r is the resultset get from db, i is the row number
            Review rowObject=new Review();
            rowObject.setId(r.getInt("id"));
            rowObject.setName(r.getString("name"));
            rowObject.setContent(r.getString("content"));
            return rowObject;
        };

        return jdbc.query(sql,reviewRowMapper);
    }
}

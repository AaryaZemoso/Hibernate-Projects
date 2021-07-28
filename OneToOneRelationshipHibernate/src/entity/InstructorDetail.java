package entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public @Data class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail()
    {

    }

    public InstructorDetail(String youtubeChannel, String hobby)
    {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

}

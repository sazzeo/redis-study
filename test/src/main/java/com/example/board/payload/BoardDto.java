package com.example.board.payload;

import com.example.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class BoardDto {

    private Long id;
    private String title;
    private String content;

    public static BoardDto getDefault() {
        return BoardDto.builder()
                .title("제목")
                .content("내용")
                .build();
    }

    public static Board toEntity(BoardDto boardDto) {
        return Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .build();
    }

}

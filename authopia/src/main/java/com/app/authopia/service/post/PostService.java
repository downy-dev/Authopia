package com.app.authopia.service.post;


import com.app.authopia.domain.dto.Pagination;
import com.app.authopia.domain.dto.PostDTO;
import com.app.authopia.domain.dto.PostType;
import com.app.authopia.domain.vo.PostVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface PostService {
    //      게시글 목록
    public List<PostDTO> getList(PostType postType);

    //      게시글 추가
    public void write(PostVO postVO);

    //      게시글 조회
    public Optional<PostDTO> read(Long id);

    //      게시글 수정
    public void modify(PostVO postVO);

    //      게시글 삭제
    public void remove(Long id);

    //      게시글 복구
    public void restore(Long id);

    default PostDTO toDTO(PostVO postVO){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postVO.getId());
        postDTO.setMemberId(postVO.getMemberId());
        postDTO.setPostName(postVO.getPostName());
        postDTO.setPostType(postVO.getPostType());
        postDTO.setPostViewCount(postVO.getPostViewCount());
        postDTO.setPostRecommend(postVO.getPostRecommend());
        postDTO.setPostRegisterDate(postVO.getPostRegisterDate());
        postDTO.setUpdateDate(postVO.getUpdateDate());
        postDTO.setPostContent(postVO.getPostContent());
        postDTO.setPostIsBlinded(postVO.getPostIsBlinded());
        return postDTO;
    }

    // 메인페이지에서 최신 인기 포스트 조회
    public List<PostDTO> getListMain(Pagination pagination);
}
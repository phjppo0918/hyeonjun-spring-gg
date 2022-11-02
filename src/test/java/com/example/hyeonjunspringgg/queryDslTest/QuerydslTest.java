package com.example.hyeonjunspringgg.queryDslTest;

import com.example.quesydslsample.dto.MemberDto;
import com.example.quesydslsample.dto.QMemberDto;
import com.example.quesydslsample.entity.Member;
import com.example.quesydslsample.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
class QuerydslTest {

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("dsl : select")
    void selectFromMember() {
        //given
        Member member = new Member();
        entityManager.persist(member);

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QMember qMember = QMember.member;

        List<MemberDto> resultDto = queryFactory
                .select(new QMemberDto(qMember.name, qMember.email))
                .from(qMember)
                .fetch();

        //when
        Member result = queryFactory
                .selectFrom(qMember)
                .fetchOne();

        //then
        assertThat(result).isEqualTo(member);
    }
}

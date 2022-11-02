package com.example.hyeonjunspringgg.queryDslTest;

import com.example.quesydslsample.entity.Member;
import com.example.quesydslsample.entity.QMember;
import com.example.quesydslsample.entity.Team;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
public class TeamMemberTest {
    @PersistenceContext
    EntityManager entityManager;

    @Test
    @DisplayName("team : member")
    void teamMember() throws Exception {
        //given
        Team teamA = new Team("A");
        Team teamB = new Team("B");
        entityManager.persist(teamA);
        entityManager.persist(teamB);

        Member member1 = new Member("member1", "aaa",teamA);
        Member member2 = new Member("member2", "bbb",teamA);
        Member member3 = new Member("member3", "ccc",teamB);
        Member member4 = new Member("member4", "ddd",teamB);
        entityManager.persist(member1);
        entityManager.persist(member2);
        entityManager.persist(member3);
        entityManager.persist(member4);

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        QMember qMember = QMember.member;
        //when
        Member result = queryFactory
                .select(qMember)
                .from(qMember)
                .where(qMember.name.eq("member1")
                        .and(qMember.team.eq(teamA)))
                .fetchOne();

        List<Member> members = queryFactory
                .select(qMember)
                .from(qMember)
                .where(qMember.team.eq(teamA))
                .fetch();
        //then
        assertThat(result.getEmail()).isEqualTo("aaa");


    }
}

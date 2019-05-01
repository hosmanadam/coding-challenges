"""https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem"""


"""
v2 - Optimized, unfortunately harder to read

- Only iterates through both lists once
- We're able to do this because both lists are ordered
"""

def climbingLeaderboard(other_scores, alice_scores):
    alice_ranks = []
    leaderboard_positions_without_alice = sorted(set(other_scores), reverse=True)
    for i, score in enumerate(leaderboard_positions_without_alice):
        while alice_scores and score <= alice_scores[-1]:
            alice_ranks.insert(0, i+1)
            alice_scores.pop()
    for score in alice_scores:
        alice_ranks.insert(0, len(leaderboard_positions_without_alice) + 1)
    return alice_ranks


"""v1 - Simple and works, but times out on humongous inputs"""
#
# def determine_rank(other_scores, score):
#     leaderboard_with_score = sorted(set(other_scores + [score]), reverse=True)
#     return leaderboard_with_score.index(score) + 1
#
#
# def climbingLeaderboard(scores, alice):
#     return [determine_rank(scores, alice_score) for alice_score in alice]

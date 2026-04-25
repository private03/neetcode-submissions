class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        if len(s) == 0:
            return

        for i in range(-2, -(len(s) + 1), -1):
            s.append(s[i])
            s.pop(i - 1)
# Balanced Delimiters

'''
Any delimiter is escaped if it follows a backslash
Any delimiter within a " or ' is escaped
Input: String 
Output: True if balanced delimiters else False
'''

from itertools import dropwhile


delim_terminal = {
    '(': ')',
    '{': '}',
    '[': ']',
    '<': '>'
}


def skip_escapes(s):
    '''generator that returns chars in s, but elides escaped chars'''
    chars = iter(s)
    for ch in chars:
        if ch == '\\':
            next(chars)
        else:
            yield ch


def skip_quotes(s):
    '''generator that returns chars in s, but elides quote chars
       it yields " or ' if it is missing one.'''
    chars = iter(s)
    for ch in chars:
        if ch in '\'"':
            if next(dropwhile(lambda x: ch != x, chars), False):
                continue
        yield ch


def solution(delimiters):
    delimters_stack = []
    for ch in skip_quotes(skip_escapes(delimiters)):
        if len(delimters_stack) != 0:
            delim = delimters_stack[-1]
            if ch == delim_terminal.get(delim, None):
                delimters_stack.pop()
                continue
        delimters_stack.append(ch)
    # More concise implementation
    # for ch in skip_quotes(skip_escapes(delimiters)):
    #     if ch  in "([{\"'":
    #         delimters_stack.append(ch)
         
    #     elif ch in ")]}":
    #         if not delimters_stack or delimters_stack.pop() != {')':'(', ']':'[', '}':'{'}[ch]:
    #             return False
    return not delimters_stack


if __name__ == "__main__":
    test1_out = solution('(())')
    assert test1_out == True

    test2_out = solution('(()(()))')
    assert test2_out == True

    test3_out = solution('))')
    assert test3_out == False

    test4_out = solution('({[<>]})')
    assert test4_out == True

    test5_out = solution('\\""[]"()')
    assert test5_out == True


import math
import unittest


def merge_sort(arr):
    length = len(arr)
    if length <= 1:
        return arr
    else:
        mid = int(math.floor(length / 2))
        left = merge_sort(arr[0:mid])
        right = merge_sort(arr[mid:])

        merged = []
        while left and right:
            a = left[0]
            b = right[0]

            if a < b:
                merged.append(a)
                left.pop(0)
            else:
                merged.append(b)
                right.pop(0)

        while left:
            merged.append(left.pop(0))

        while right:
            merged.append(right.pop(0))

        return merged


def is_ascending(arr):
    prev_val = None
    for val in arr:
        if prev_val is None:
            prev_val = val
        elif val < prev_val:
            raise Exception('Value is not in ascending order.')
        else:
            prev_val = val


if __name__ == '__main__':
    arr = [3, 2, 1]
    got = merge_sort(arr)
    is_ascending(got)

    arr = [3, 2, 1, 1000, 999, -1]
    got = merge_sort(arr)
    is_ascending(got)

    arr = [-3, -2, -1, -1, -1000]
    got = merge_sort(arr)
    is_ascending(got)

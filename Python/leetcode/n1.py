def twoSum(nums, target):
    look_for = {}
    for n, x in enumerate(nums):
        try:
            return [look_for[x] + 1, n + 1]
        except KeyError:
            look_for.setdefault(target - x, n)

print(twoSum([3,2,3], 6))
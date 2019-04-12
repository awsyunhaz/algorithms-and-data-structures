def twoSum(nums: 'List[int]', target: 'int') -> 'List[int]':
    dic = {}
    for index in range(len(nums)):
        if dic.get(target-nums[index]) is not None:
            return [dic[target-nums[index]], index]
        else:
            dic[nums[index]] = index
    return None

if __name__ == '__main__':
    print(twoSum([2, 7, 11, 15], 9))

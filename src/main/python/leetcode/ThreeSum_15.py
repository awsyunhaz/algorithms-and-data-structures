def threeSum(nums: 'List[int]') -> 'List[List[int]]':
    nums.sort()
    result = []
    for i in range(len(nums)-2):
        if (i>0 and nums[i-1]==nums[i]):
            continue
        lo, hi = i+1, len(nums)-1
        while lo<hi:
            sum = nums[i]+nums[lo]+nums[hi]
            if (sum==0):
                result.append([nums[i], nums[lo], nums[hi]])
                while (lo<hi and nums[lo]==nums[lo+1]):
                    lo+=1
                while (lo<hi and nums[hi]==nums[hi-1]):
                    hi-=1
                lo+=1
                hi-=1
            elif sum<0:
                lo+=1
            else:
                hi-=1
    return result

if __name__=='__main__':
    print(threeSum([-1, 0, 1, 2, -1, -4]))

'''
Author: your name
Date: 2021-01-13 19:04:51
LastEditTime: 2021-01-15 14:32:08
LastEditors: Please set LastEditors
Description: 实现一个特殊的栈，在实现栈的基础上，实现返回栈中最小元素的操作。
要求：
    1. pop、push、getMin操作的时间复杂度都是O(1)
    2. 设计的栈类型可以使用现成的栈结构
FilePath: /cheng_xu_yuan_dai_ma_mian_shi_zhi_nan_v2/chapter_1_stack_and_queue/Problem_01_GetMinStack.py
'''

class Problem_01_GetMinStack:
    _minStack = []
    _dataStack = []
    
    def push(self, value):
        self._dataStack.append(value)
        
        if len(self._minStack) == 0:
            self._minStack.append(value)
        # 注意这个 >= 的条件，换成 > 会出问题
        elif self.getMin() >= value:
            self._minStack.append(value)
            

    def pop(self):
        if len(self._dataStack) == 0:
            raise Exception('stack is empty')
        value = self._dataStack.pop(len(self._dataStack) - 1)
        if value == self._minStack[len(self._minStack) - 1]:
            self._minStack.pop(len(self._minStack) - 1)

        return value


    def getMin(self):
        if len(self._minStack) == 0:
            raise Exception('stack is empty')
        
        return self._minStack[len(self._minStack) - 1]
        

if __name__ == "__main__":
    stack = Problem_01_GetMinStack()
    stack.push(3)
    print(stack.getMin())
    stack.push(4)
    print(stack.getMin())
    stack.push(1)
    print(stack.getMin())
    stack.pop()
    print(stack.getMin())
    stack.pop()
    print(stack.getMin())
    stack.pop()
    print(stack.getMin())
    
    
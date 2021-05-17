import itertools as tools

ls = tools.permutations("ABC")

letters = ['a','b','c','d']
numbers =[0,1,2,3]
names = ['Corey','Nicole']

# result = tools.combinations(letters,2)
# result = tools.permutations(letters)
result = tools.product(letters,repeat=6)

# print(next(counter))
# print(next(counter))
# print(next(counter))
# print(next(counter))
# print(next(counter))
# print(next(counter))

#print(list(result))

for item in result:
    print(item)
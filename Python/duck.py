class Duck:
    def fly(self):
        print("Duck flying")

class Airplane:
    def fly(self):
        print("Airplane flying")

class Whale:
    def swim(self):
        print("Whale swimming")

def lift_off(entity):
    entity.fly()

duck = Duck()
airplane = Airplane()
whale = Whale()

print(dir(duck))
lift_off(duck) # prints `Duck flying`
print(dir(airplane))
lift_off(airplane) # prints `Airplane flying`
print(dir(whale))
lift_off(whale) # Throws the error `'Whale' object has no attribute 'fly'`

def main():
    x = 3
    y = x
    print(x, y)

    print(x == y)
    print(x is y)
    print()

    x = 5 # makes a new x
    print(x, y)
    print(x is y)
    print()

    a = [1,2,3]
    b = a   # reference copy
    print(a, b)
    print(a is b)
    print()

    a[0] = 5
    print(a, b)

    print(a == b)
    print(a is b)
    print()

if __name__ == "__main__":
    main()

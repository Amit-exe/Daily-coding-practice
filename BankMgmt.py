import re

no_of_star = 100
print(" BANK MANAGEMENT SYSTEM ".center(no_of_star, '*'))


class BankManagement():
    def __init__(self):
        self.name = []
        self.contact = []
        self.email = []
        self.address_proof = []
        self.pan = []
        self.dob = []
        self.passwd = []

        # flags for user registration
        self.userName_flag = False
        self.userContact_flag = False
        self.userEmail_flag = False
        self.userPanno_flag = False
        self.userDOB_flag = False
        self.password_flag = False

        #user login
        self.UserLogin_flag = False
        # account Related
        self.balance = []
        self.accountHistory = []
        self.emi = []

    def loginUser(self, uname, passwd):
        if uname in self.name:
            pos = self.name.index(uname)
            if passwd == self.passwd[pos]:
                self.UserLogin_flag = True
                return self.UserLogin_flag
            else:
                return 'Password is incorrect'
        else:
            return 'Username is invalid'


    def checkBalance(self,uname):
        pos = self.name.index(uname)
        bal = self.balance[pos]
        return f"your account balance is {bal}".center(no_of_star,'*')

    def deposit(self,uname,amount):
        pos = self.name.index(uname)
        self.balance[pos] += amount
        bal = self.balance[pos]
        self.accountHistory[pos].append('Deposited : '+ str(amount) + " " + str(bal))
        return f"Money deposited your current account balance is {bal}".center(no_of_star, '*')

    def withdraw(self,uname,amount):
        pos = self.name.index(uname)
        if amount <= self.balance[pos]:
            self.balance[pos] -= amount
            bal = self.balance[pos]
            self.accountHistory[pos].append('Withdrawn:  ' + str(amount) + " " + str(bal))
            return f"Transaction completed successfully your current account balance {bal}".center(no_of_star, '*')
        else:
            bal = self.balance[pos]
            return f"Insufficient balance try amount less than equal to {bal}".center(no_of_star, '*')


    def history(self, uname):
        pos = self.name.index(uname)
        print('Transaction | Amount | Balance')
        for log in self.accountHistory[pos]:
            print(log)

    def loanEmi(self,amount,rate,time):
        total_amount = amount*((1+rate/100)**time)
        months = time*12
        month_emi = total_amount/months
        return 'Monthly Emi will be',month_emi

    # valid user name (only alphabets)

    def validateUsername(self, name):
        name_length = len(name)
        x = re.findall('[a-z]+', name)

        if len(x[0]) == name_length:
            return True
        else:
            return False

    # check valid contact no
    def validateContact(self, contact):
        ptr = r"[6-9]\d{9}"
        x = re.findall(ptr, contact)
        if len(x) > 0:
            return True
        else:
            return False

            # check valid email id

    def validateEmail(self, email):
        ptr = r"^[a-zA-Z0-9\.]+@[a-z]+\.[a-z]+"
        x = re.findall(ptr, email)
        if len(x) > 0:
            return True
        else:
            return False

            # check valid Aadhar no

    def validateAadhar(self, address_proof):
        ptr = r"\d{12}"
        x = re.findall(ptr, address_proof)
        if len(x) > 0:
            return True
        else:
            return False

            # check panno validation

    def validatePanno(self, panno):
        if len(panno) != 10:
            return False

        ptr = r"^[A-Z]{3}[PCFAHT][A-Z][0-9]{4}[A-Z]"

        x = re.findall(ptr, panno)
        len(x)
        if len(x) > 0:

            return True
        else:
            return False

            # check DOB validation

    def validateDOB(self, dob):
        if len(dob) != 10:
            return False

        ptr = r"^[0-9]{2}-[0-9]{2}-[0-9]{4}"

        x = re.findall(ptr, dob)
        len(x)
        if len(x) > 0:

            return True
        else:
            return False

    def registerUser(self, name, contact, email, address_proof, pan, dob, passwd, confirm_pass):
        self.userName_flag = self.validateUsername(name)
        if not self.userName_flag:
            return "Username is not valid try only with alphabets"

        if contact in self.contact:
            return "Contact Already Exist"
        self.userContact_flag = self.validateContact(contact)
        if not self.userContact_flag:
            return "Contact Number is not valid"

        if email in self.email:
            return "Email Id is Already registered with another user"
        self.userEmail_flag = self.validateEmail(email)
        if not self.userEmail_flag:
            return "Email Id is not valid"

        self.userAadhar_flag = self.validateAadhar(address_proof)
        if not self.userAadhar_flag:
            return "Address Proof(Aadhar no) is not valid"

        self.userPanno_flag = self.validatePanno(pan)
        if not self.userPanno_flag:
            return "PanNo is not valid"

        self.userDOB_flag = self.validateDOB(dob)
        if not self.userDOB_flag:
            return "Date of Birth is not in valid format try DD-MM-YYYY"

        if len(passwd) >= 8:
            if passwd == confirm_pass:
                self.password_flag = True
            else:
                return "Password MisMatch Plz try again"
        else:
            return "Password should be greater than or equal to 8 characters"

        if self.userName_flag == True and self.userContact_flag == True and self.userEmail_flag == True and self.userAadhar_flag == True and self.userPanno_flag == True and self.userDOB_flag == True and self.password_flag == True:
            self.name.append(name)
            self.contact.append(contact)
            self.email.append(email)
            self.address_proof.append(address_proof)
            self.pan.append(pan)
            self.dob.append(dob)
            self.passwd.append(passwd)

            self.balance.append(0)
            self.accountHistory.append([])
            return f"User {name} is Successfully Registered"


app = BankManagement()

while True:
    print("1- Login User\n2 - Register User \n3 - Exit\n")
    ch = int(input("Enter your choice:"))
    if ch == 1:
        print(" Login section ".center(no_of_star, '*'))
        uname = input('Enter username: ').strip()
        passwd = input('Enter password: ').strip()
        lflag = app.loginUser(uname, passwd)
        if lflag != True:
            print(f' {lflag} '.center(no_of_star, '*'))
        else:
            print(f' User Login Successfully '.center(no_of_star, '*'))
            while True:

                print("1- Check Balance\n2 - Deposit Amount \n3 - Withdraw \n4 - History \n5 - Loan EMI \n6 - Exit")
                u_ch = int(input('Enter your Choice: '))
                if u_ch == 1:
                    res = app.checkBalance(uname)
                    print(f' {res} '.center(no_of_star, '*'))
                elif u_ch == 2:
                    amount = int(input('Enter the amount to deposit').strip())
                    res=app.deposit(uname,amount)
                    print(f' {res} '.center(no_of_star, '*'))

                elif u_ch == 3:
                    amount = int(input('Enter the amount to withdraw').strip())
                    res= app.withdraw(uname, amount)
                    print(f' {res} '.center(no_of_star, '*'))
                elif u_ch == 4:
                    app.history(uname)
                elif u_ch == 5:
                    print(" welcome to EMI section ".center(no_of_star, '*'))
                    amount = int(input("enter the loan amount ").strip())
                    rate = int(input("enter the rate of intrest ").strip())
                    time = int(input('enter the time period in years ').strip())

                    res = app.loanEmi(amount,rate,time);
                    print(f' {res} '.center(no_of_star, '*'))
                elif u_ch == 6:
                    print(" Logout Successfully ".center(no_of_star, '*'))
                    break
                else:
                    print(" Invalid User choice ".center(no_of_star, '*'))


    elif ch == 2:
        print(" Registration section ".center(no_of_star, '*'))
        name = input('Enter your name: ').strip().lower()
        contact = input('Enter your contact number: ').strip()
        email = input('Enter your Email Address: ').strip()
        address_proof = input('Enter your address proof: ').strip()
        pan = input('Enter your PAN number:').strip().upper()
        dob = input('Enter your Date of Birth in (DD-MM-YYYY) only: ').strip()
        passwd = input('Enter your password: ').strip()
        confirm_pass = input('Confirm your password: ').strip()
        rflag = app.registerUser(name, contact, email, address_proof, pan, dob, passwd, confirm_pass)

        print(f' {rflag} '.center(no_of_star, '*'))

    elif ch == 3:
        print(" Thank you for Visiting ".center(no_of_star, '*'))
        break
    else:
        print(" Invalid choice ".center(no_of_star, '*'))

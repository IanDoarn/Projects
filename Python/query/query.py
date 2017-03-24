import json
import os
import getpass
from pySMS.pgsql import postgres

path = os.path.dirname(os.path.realpath(__file__))

p = postgres.Postgres()

p._user = "reader"
p._pass = "ZimmerBiomet"
p._host = "vsbslgprd01.zmr.zimmer.com"

p.test_connection()

p.establish_connection()

with open(path + '\\bins.sql', 'r')as f:
    query_bins = f.read()

with open(path + '\\loans.sql', 'r')as f:
    query_loans = f.read().replace('\n', ' ')

print('Running bins')
bin_data = p.execute(query_bins)

print('Running loans')
loan_data = p.execute(query_loans)

bins = []
loans = []

for i in bin_data:
    i = list(i)
    for n in range(len(i)):
        if i[n] == None:
            i[n] = "None"
        if type(i[n]) != str:
            i[n] = str(i[n])
    bins.append(i[1:len(i)-7])

for i in loan_data:
    i = list(i)
    for n in range(len(i)):
        if i[n] == None:
            i[n] = "None"
        if type(i[n]) != str:
            i[n] = str(i[n])
    loans.append(i[1:len(i)-8])


data = {"loans": loans,
        "bins": bins}

desktop = os.sep.join(["C:", "Users", getpass.getuser(), "Desktop"])


print('Writing json file')
with open(desktop + '\\mutation_data.json', 'w')as fp:
    json.dump(data, fp, sort_keys=False, indent=5)

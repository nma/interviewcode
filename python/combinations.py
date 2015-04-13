'''
What is the difference between a permutations and combinations?
-- http://www.mathsisfun.com/combinatorics/combinations-permutations.html

Combinations is when order does not matter. 
    Apple, Bread, Butter   -- it is the same set of three regardless of how we order them
Permutations is when order does matter. 
    A password, 1234
    There are many ordering, but only 1 works!

In terms of size of possible orderings, we have permutations > combinations.
'''


results = []
def build_combinations(inputs, partial_combinations):
    partial_results = []
    
    # grab the first parameter from the inputs
    paramter = inputs.iteritems().next()
    param_name = paramter[0]
    param_values = paramter[1]
    
    for value in param_values:
        # define a new param_combination
        param_combination = {param_name: value}
        # combine all previous partial_combinations into our param_combination
        param_combination.update(partial_combinations)
        partial_results.append(param_combination)

    if len(inputs) <= 1:
        results.extend(partial_results)
    else:
        for partial_combination in partial_results:
            inputs_sub_param = dict(inputs)
            del inputs_sub_param[param_name]
            build_combinations(inputs_sub_param, partial_combination)

inputs = { 
        'a' : (1,2),
        'b' : (3,4),
        'c' : (5,6,7)
        }
build_combinations(inputs, {})

for result in results:
    print result

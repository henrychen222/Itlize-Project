import React, { useState, useEffect } from 'react';

import styles from './Survey.module.sass';
import SelectState from '../../Icons/SelectState';
import CheckboxNoSelected from '../../Icons/CheckboxNoSelected';
import Trash from '../../Icons/Trash';
import Plus from '../../Icons/Plus';
import CheckboxSelected from '../../Icons/CheckboxSelected';
import { getFormulaByProjectId, updateFormula } from '../../utils/api/api';
import {
  surveyEntity2object,
  surveyObject2Entity
} from '../../utils/data/formula';

export function Survey({ chosenProjectId, submitted, setSubmitted }) {
  const [scope, setScope] = useState({});
  const [survey, setSurvey] = useState([]);

  useEffect(() => {
    const load = async () => {
      const result = await getFormulaByProjectId(chosenProjectId);
      setScope(result.scope);
      setSurvey(surveyEntity2object(result.survey));
    };

    load();
  }, [chosenProjectId]);

  useEffect(() => {
    const handleSubmit = async () => {
      if (submitted) {
        const formula = await getFormulaByProjectId(chosenProjectId);
        formula.scope = scope;
        formula.survey = surveyObject2Entity(survey);
        await updateFormula(formula);

        setSubmitted(false);
      }
    };

    handleSubmit();
  }, [chosenProjectId, scope, setSubmitted, submitted, survey]);

  const captureFormulaError = (event, index, setter) => {
    event.persist();

    let formula = event.target.value;

    setter(values => {
      const newValues = [...values];
      newValues[index] = { ...newValues[index], formula, error: '' };

      values.forEach(({ field, type }) => {
        if (type === 'number') {
          const regExp = new RegExp(field, 'g');
          formula = formula.replace(regExp, 1);
        }
      });

      try {
        eval(formula);
      } catch ({ message }) {
        newValues[index] = { ...newValues[index], error: message };
      }

      return newValues;
    });
  };

  const handleClick = (name, value, setter) => {
    setter(values => ({
      ...values,
      [name]: !value
    }));
  };

  const handleSurveyChange = (event, index, setter) => {
    event.persist();
    const { name, value } = event.target;
    setter(values => {
      const newValues = [...values];
      newValues[index] = { ...newValues[index], [name]: value };
      return newValues;
    });
  };

  const renderScope2listItem = ([name, value], scopeSetter) => {
    if (name === 'name') {
      return (
        <li key={name}>
          <span>{name}</span>
          <SelectState />
        </li>
      );
    }

    return (
      <li key={name}>
        <span>{name}</span>
        {value ? (
          <CheckboxSelected
            style={{
              cursor: 'pointer'
            }}
            onClick={() => handleClick(name, value, scopeSetter)}
          />
        ) : (
          <CheckboxNoSelected
            style={{
              cursor: 'pointer'
            }}
            onClick={() => handleClick(name, value, scopeSetter)}
          />
        )}
      </li>
    );
  };

  const renderSurvey = (currentSurvey, index, surveySetter) => {
    const { field, type, formula, error } = currentSurvey;

    return (
      <div key={index}>
        <label>
          Field
          <input
            type="text"
            value={field}
            name="field"
            onChange={event => handleSurveyChange(event, index, surveySetter)}
          />
        </label>

        <label>
          Type
          <select
            name="type"
            onChange={event => handleSurveyChange(event, index, surveySetter)}
            value={type}
          >
            <option value="number">Number</option>
            <option value="text">Text</option>
            <option value="formula">Formula</option>
          </select>
        </label>

        <label className={type === 'formula' ? '' : styles.hiding}>
          Formula
          <input
            type="text"
            name="formula"
            value={formula}
            onChange={event => captureFormulaError(event, index, surveySetter)}
          />
          <span>{type === 'formula' && error}</span>
        </label>

        <span>
          <Trash
            onClick={() =>
              surveySetter(values => {
                const newValues = [...values];
                newValues.splice(index, 1);
                return newValues;
              })
            }
          />
        </span>
      </div>
    );
  };

  return (
    <main className={styles.survey}>
      <aside>
        <header>Project Scope Fields</header>
        <ul>
          {Object.entries(scope).map(s => renderScope2listItem(s, setScope))}
        </ul>
      </aside>

      <section>
        <header>Quantity Survey Fields</header>

        {survey.length
          ? survey.map((s, index) => renderSurvey(s, index, setSurvey))
          : null}

        <footer>
          Add Field
          <Plus
            onClick={() =>
              setSurvey(values => [
                ...values,
                {
                  field: '',
                  type: 'number',
                  formula: ''
                }
              ])
            }
            fill="white"
          />
        </footer>
      </section>
    </main>
  );
}
